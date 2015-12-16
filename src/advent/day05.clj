(ns advent.day05)

;; --- Day 5: Doesn't He Have Intern-Elves For This? ---

;; Santa needs help figuring out which strings in his text file are naughty or
;; nice.

;; A nice string is one with all of the following properties:

;;     It contains at least three vowels (aeiou only), like aei, xazegov, or
;;     aeiouaeiouaeiou.
;;
;;     It contains at least one letter that appears twice in a row, like xx,
;;     abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
;;
;;     It does not contain the strings ab, cd, pq, or xy, even if they are part
;;     of one of the other requirements.

;; For example:

;;     ugknbfddgicrmopn is nice because it has at least three
;;     vowels (u...i...o...), a double letter (...dd...), and none of the
;;     disallowed substrings.
;;
;;     aaa is nice because it has at least three vowels and a double letter,
;;     even though the letters used by different rules overlap.
;;
;;     jchzalrnumimnmhp is naughty because it has no double letter.
;;
;;     haegwjzuvuyypxyu is naughty because it contains the string xy.
;;
;;     dvszwmarrgswjxmb is naughty because it contains only one vowel.

;; How many strings are nice?

;; input file save to resource/day05.txt
(def data
  (slurp (clojure.java.io/resource "day05.txt")))

;; It contains at least three vowels (aeiou only), like aei, xazegov, or
;; aeiouaeiouaeiou.
(defn rule-1 [s]
  (->> (seq s)
       (filter #{\a \e \i \o \u})
       (count)
       (<= 3)))

;; It contains at least one letter that appears twice in a row, like xx,
;; abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
(defn rule-2 [s]
  (re-find #"(.)\1" s))

;; It does not contain the strings ab, cd, pq, or xy, even if they are part of
;; one of the other requirements.
(defn rule-3 [s]
  (let [forbidden #{"ab" "cd" "pq" "xy"}]
    (not (some #(.contains s %) forbidden))))

;; A nice string must fit rule-1, rule-2 and rule-3.
(defn nice-string? [s]
  (and (rule-1 s) (rule-2 s) (rule-3 s)))

;; solve all problem, problem must separate by '\n'
(defn solve-part1 [input]
  (->>
   (map nice-string? (clojure.string/split input #"\n"))
   (filter true?)
   (count)))

;; part-1
(solve-part1 data)
