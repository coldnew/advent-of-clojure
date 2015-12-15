(ns advent.day01-spec
  (:require [speclj.core :refer :all]
            [speclj.run.standard]
            [advent.day01 :refer :all]))

(defn verify [test result]
  (it (str test " is " result)
      (should (= result (solve test)))))

(describe
 "Testcase in examples: day01"
 (verify "(())" 0)
 (verify "()()" 0)
 (verify "((("  3)
 (verify "(()(()("  3)
 (verify "))((((("  3)
 (verify "())"  -1)
 (verify "))("  -1)
 (verify ")))"  -3)
 (verify ")())())"  -3)
 )