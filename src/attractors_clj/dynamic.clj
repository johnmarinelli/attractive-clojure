(ns attractors-clj.dynamic
  (:require [quil.core :as q]))

(defn tell [in] (println (.toString in)) in)

(defn dx [x y sigma]
  (* sigma (- y x)))
(defn dy [x y z rho]
  (- (* x (- rho z)) y))
(defn dz [x y z beta]
  (- (* x y) (* beta z)))

(defn third [coll] (nth coll 2))

; x y z are system state, sigma, rho, beta are system parameters
(defn lorenz-system []
  (let [sigma 10.0
        rho 28.0
        beta 2.66
        p0 [0.1 0.1 0.2]
        t 0.01]
    (loop [pts []
           pt p0
           itr 0]
      (if (< itr 10000)
        (recur (conj pts pt)
               [(+ (first pt) (* t (dx (first pt) (second pt) sigma)))
                (+ (second pt) (* t (dy (first pt) (second pt) (third pt) rho)))
                (+ (third pt) (* t (dz (first pt) (second pt) (third pt) beta)))]
               (inc itr))
        pts))))

(def lorenz (lorenz-system))

(defn setup []
  (q/smooth)
  (q/frame-rate 20))
; float ypos= mouseY/3;
; float xpos= cos (radians (rotation))*orbitRadius;
; float zpos= sin (radians (rotation))*orbitRadius;
(defn draw [state]
  (q/background 255)
  (q/fill (q/random 255))
  (q/camera 
   (- (* 10 (q/frame-count)) (/ (q/width) 2.0))
   (- (* 10 (q/frame-count)) (/ (q/height) 2.0))
   (/ (/ (q/height) 2.0) (Math/tan (/ (* Math/PI 60.0) 360.0)))
   (/ (q/width) 2.0) 
   (/ (q/height) 2.0) 
   0 
   0 
   1 
   0)
  (q/print-camera)
  (q/with-translation [(/ (q/width) 2) (/ (q/height) 2)]
    (doseq [[x y z] (take (q/frame-count) lorenz)]
     (q/point x y z))))

