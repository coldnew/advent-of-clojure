(ns advent.day04-spec
  (:require [speclj.core :refer :all]
            [speclj.run.standard]
            [advent.day04 :refer :all]))

(defn verify-part1 [test result]
  (it (str test " is " result)
      (should (= result (solve-part1 test)))))

(describe
 "Testcase in examples: day04 part1"
 (verify-part1 "abcdef"  "609043")
 (verify-part1 "pqrstuv" "1048970"))
