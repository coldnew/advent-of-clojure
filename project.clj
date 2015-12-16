(defproject advent "0.1.0-SNAPSHOT"
  :description "My solutions to the Advent of Code"
  :url "https://github.com/coldnew/advent-of-clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0-RC3"]]
  :test-paths ["spec"]
  :profiles {:dev {:dependencies [[speclj "3.3.0"]]}}
  :plugins [[speclj "3.3.0"]
            [michaelblume/lein-marginalia "0.9.0"]])
