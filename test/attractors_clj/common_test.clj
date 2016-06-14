(ns attractors-clj.common-test
  (:require [clojure.test :refer :all]
            [attractors-clj.common :as c]))
(deftest test-tell []
  (is (= 1 (c/tell 1))))

(deftest test-third []
  (is (= 4 (c/third [1 2 4]))))
