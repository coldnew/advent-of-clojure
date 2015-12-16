(ns advent.day02-spec
  (:require [speclj.core :refer :all]
            [speclj.run.standard]
            [advent.day02 :refer :all]))

(defn verify-part1 [test result]
  (it (str test " is " result)
      (should (= result (solve-part1 test)))))

(describe
 "Testcase in examples: day02 part-1"
 (verify-part1 "2x3x4"  58)
 (verify-part1 "1x1x10" 43))

(defn verify-part2 [test result]
  (it (str test " is " result)
      (should (= result (solve-part2 test)))))

(describe
 "Testcase in examples: day02 part-2"
 (verify-part2 "2x3x4"  34)
 (verify-part2 "1x1x10" 14))