(ns advent.day02-spec
  (:require [speclj.core :refer :all]
            [speclj.run.standard]
            [advent.day02 :refer :all]))

(defn verify [test result]
  (it (str test " is " result)
      (should (= result (solve test)))))

(describe
 "Testcase in examples: day02"
 (verify "2x3x4"  58)
 (verify "1x1x10" 43)
 )