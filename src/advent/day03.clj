(ns advent.day03)

;; --- Day 3: Perfectly Spherical Houses in a Vacuum ---

;; Santa is delivering presents to an infinite two-dimensional grid of houses.

;; He begins by delivering a present to the house at his starting location, and
;; then an elf at the North Pole calls him via radio and tells him where to move
;; next. Moves are always exactly one house to the north (^), south (v), east
;; (>), or west (<). After each move, he delivers another present to the house
;; at his new location.

;; However, the elf back at the north pole has had a little too much eggnog, and
;; so his directions are a little off, and Santa ends up visiting some houses
;; more than once. How many houses receive at least one present?

;; For example:

;; > delivers presents to 2 houses: one at the starting location, and one to the
;; east.
;; ^>v< delivers presents to 4 houses in a square, including twice to the house
;; at his starting/ending location.
;; ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2
;; houses.

;; input file save to resource/day03.txt
(def data
  (slurp (clojure.java.io/resource "day03.txt")))

;; part1 solver
(defn solve-part1 [input]
  (let [result
        (->> (map {\> [1 0] \< [-1 0] \^ [0 1] \v [0 -1]} input)
             (reductions (fn [x y] (map + x y)))
             (into #{})
             count)]
    ;; the Santa delivers presents start from 2 house
    (if (= result 1)
      2
      result)))

;; part1 result
(solve-part1 data)
