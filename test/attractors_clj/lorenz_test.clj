(ns attractors-clj.lorenz-test
  (:require [clojure.test :refer :all]
            [attractors-clj.lorenz :as l]))

(deftest dx []
  (is (= 3 (l/dx 1 2 3))))

(deftest dy []
  (is (= -1 (l/dy 1 2 3 4))))

(deftest dz []
  (is (= -10 (l/dz 1 2 3 4))))


