(ns advent.day05-spec
  (:require [speclj.core :refer :all]
            [speclj.run.standard]
            [advent.day05 :refer :all]))

(defn verify-part1 [test result]
  (it (str test " is " result)
      (should (= result (solve-part1 test)))))

(describe
 "Testcase in examples: day05 part1"
 (verify-part1 "ugknbfddgicrmopn" 1)
 (verify-part1 "aaa"              1)
 (verify-part1 "jchzalrnumimnmhp" 0)
 (verify-part1 "haegwjzuvuyypxyu" 0)
 (verify-part1 "dvszwmarrgswjxmb" 0))

(defn verify-part2 [test result]
  (it (str test " is " result)
      (should (= result (solve-part2 test)))))

(describe
 "Testcase in examples: day05 part2"
 (verify-part2 "qjhvhtzxzqqjkmpb" 1)
 (verify-part2 "xxyxx"            1)
 (verify-part2 "uurcxstgmygtbstg" 0)
 (verify-part2 "ieodomkazucvgmuy" 0))
