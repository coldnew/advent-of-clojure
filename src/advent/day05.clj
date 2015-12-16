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
  (boolean (re-find #"(.)\1" s)))

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

;; --- Part Two ---

;; Realizing the error of his ways, Santa has switched to a better model of
;; determining whether a string is naughty or nice. None of the old rules apply,
;; as they are all clearly ridiculous.

;; Now, a nice string is one with all of the following properties:

;;     It contains a pair of any two letters that appears at least twice in the
;;     string without overlapping, like xyxy (xy) or aabcdefgaa (aa), but not
;;     like aaa (aa, but it overlaps).
;;
;;     It contains at least one letter which repeats with exactly one letter
;;     between them, like xyx, abcdefeghi (efe), or even aaa.

;; For example:

;;     qjhvhtzxzqqjkmpb is nice because is has a pair that appears twice (qj)
;;     and a letter that repeats with exactly one letter between them (zxz).
;;
;;     xxyxx is nice because it has a pair that appears twice and a letter that
;;     repeats with one between, even though the letters used by each rule
;;     overlap.
;;
;;     uurcxstgmygtbstg is naughty because it has a pair (tg) but no repeat with
;;     a single letter between them.
;;
;;     ieodomkazucvgmuy is naughty because it has a repeating letter with one
;;     between (odo), but no pair that appears twice.
;;

;; How many strings are nice under these new rules?

;; It contains a pair of any two letters that appears at least twice in the
;; string without overlapping, like xyxy (xy) or aabcdefgaa (aa), but not like
;; aaa (aa, but it overlaps).
(defn rule-1* [s]
  (boolean (re-find #"([a-z][a-z]).*\1" s)))

;; It contains at least one letter which repeats with exactly one letter
;; between them, like xyx, abcdefeghi (efe), or even aaa.
(defn rule-2* [s]
  (boolean (re-find #"([a-z]).\1" s)))

;; A nice string must fit rule-1* and rule-2*
(defn nice-string?* [s]
  (and (rule-1* s) (rule-2* s)))

;; solve all problem, problem must separate by '\n'
(defn solve-part2 [input]
  (->>
   (map nice-string?* (clojure.string/split input #"\n"))
   (filter true?)
   (count)))

;; part-2
(solve-part2 data)
