(ns attractors-clj.dynamic-test
  (:require [clojure.test :refer :all]
            [attractors-clj.dynamic :as d]))

(deftest test-tell []
  (is (= 1 (d/tell 1))))

(deftest test-third []
  (is (= 4 (d/third [1 2 4]))))

(deftest dx []
  (is (= 3 (d/dx 1 2 3))))

(deftest dy []
  (is (= -1 (d/dy 1 2 3 4))))

(deftest dz []
  (is (= -10 (d/dz 1 2 3 4))))


