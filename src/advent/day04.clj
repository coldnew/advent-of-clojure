(ns advent.day04
  (:import [java.security.MessageDigest]))

;; --- Day 4: The Ideal Stocking Stuffer ---

;; Santa needs help mining some AdventCoins (very similar to bitcoins) to use as
;; gifts for all the economically forward-thinking little girls and boys.

;; To do this, he needs to find MD5 hashes which, in hexadecimal, start with at
;; least five zeroes. The input to the MD5 hash is some secret key (your puzzle
;; input, given below) followed by a number in decimal. To mine AdventCoins, you
;; must find Santa the lowest positive number (no leading zeroes: 1, 2, 3, ...)
;; that produces such a hash.

;; For example:

;; If your secret key is abcdef, the answer is 609043, because the MD5 hash of
;; abcdef609043 starts with five zeroes (000001dbbfa...), and it is the lowest
;; such number to do so.
;;
;; If your secret key is pqrstuv, the lowest number it combines with to make an
;; MD5 hash starting with five zeroes is 1048970; that is, the MD5 hash of
;; pqrstuv1048970 looks like 000006136ef....

;; Your puzzle input is ckczppom.

;; the puzzle input
(def data "ckczppom")

;; method to calculate md5
(defn md5 [s]
  (->> (.getBytes s)
       (.digest (java.security.MessageDigest/getInstance "MD5"))
       (map #(format "%02x" %))
       (apply str)))

(defn solve-part1 [input]
  (loop [c 0]
    (if (= "00000"
           (-> (str input c)
               (md5)
               (subs 0 5)))
      (str c)
      (recur (inc c)))))

;; part1 result
(solve-part1 data)

;; --- Part Two ---

;; Now find one that starts with six zeroes.

;; Your puzzle input is still ckczppom.

(defn solve-part2 [input]
  (loop [c 0]
    (if (= "000000"
           (-> (str input c)
               (md5)
               (subs 0 6)))
      (str c)
      (recur (inc c)))))

;; part2 result
(solve-part2 data)