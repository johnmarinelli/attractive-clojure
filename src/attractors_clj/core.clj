(ns attractors-clj.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [attractors-clj.dynamic :as dynamic]))

(q/defsketch example
  :title "Oh so many grey circles"
  :setup dynamic/setup
  :draw dynamic/draw
  :size [500 500]
  :renderer :opengl
  :middleware [m/fun-mode m/navigation-3d])

(defn -main [& args])
