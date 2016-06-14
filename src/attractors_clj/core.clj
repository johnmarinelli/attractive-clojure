(ns attractors-clj.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [attractors-clj.lorenz :as lorenz]
            [attractors-clj.mandelbrot :as mandelbrot]))

(q/defsketch example
  :title "STAY TRIPPY MANE"
  :setup mandelbrot/setup
  :draw mandelbrot/draw
  :size [500 500]
  :renderer :opengl
  :middleware [m/fun-mode m/navigation-3d])

(defn -main [& args])
