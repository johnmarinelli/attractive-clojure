(ns attractors-clj.common)
(defn tell [in] (println (.toString in)) in)
(defn third [coll] (nth coll 2))

(deftype Complex [^double real ^double i])

(defmulti .+ #('(class %1) (class %2)))
(defmethod .+ '(Complex, Complex) [c1, c2]
  (Complex. (+ (.real c1) (.real c2)) (+ (.i c1) (.i c2))))

(defmulti .* class)
(defmethod .* '(Complex, Complex) [c1, c2]
  (Complex. (* (.real c1) (.real c2)) (* (.i c1) (.i c2))))
