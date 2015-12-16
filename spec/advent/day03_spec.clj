(ns advent.day03-spec
  (:require [speclj.core :refer :all]
            [speclj.run.standard]
            [advent.day03 :refer :all]))

(defn verify-part1 [test result]
  (it (str test " is " result)
      (should (= result (solve-part1 test)))))

(describe
 "Testcase in examples: day03 part1"
 (verify-part1 ">"          2)
 (verify-part1 "^>v<"       4)
 (verify-part1 "^v^v^v^v^v" 2))
