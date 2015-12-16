(ns advent.day01-spec
  (:require [speclj.core :refer :all]
            [speclj.run.standard]
            [advent.day01 :refer :all]))

(defn verify-part1 [test result]
  (it (str test " is " result)
      (should (= result (solve-part1 test)))))

(describe
 "Testcase in examples: day01 part-1"
 (verify-part1 "(())"     0)
 (verify-part1 "()()"     0)
 (verify-part1 "((("      3)
 (verify-part1 "(()(()("  3)
 (verify-part1 "))((((("  3)
 (verify-part1 "())"     -1)
 (verify-part1 "))("     -1)
 (verify-part1 ")))"     -3)
 (verify-part1 ")())())" -3))

(defn verify-part2 [test result]
  (it (str test " is " result)
      (should (= result (solve-part2 test)))))

(describe
 "Testcase in examples: day01 part-2"
 (verify-part2 ")"     1)
 (verify-part2 "()())" 5))
