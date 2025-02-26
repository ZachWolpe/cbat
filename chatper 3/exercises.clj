(ns hello)

(defn test-function []
  (println "Hello from VS Code!")
  (+ 1 2 3))

(test-function)


(defn add-100 [x]
  (+ x 100))


(println (add-100 10))


;; Exercise 1
(println "------------------------------- Exercise 1 -------------------------------")
(println (str "Hello" " " 4433))
(println (vector 1 2 3 4 5))
(println (hash-map :a 1 :b 2 :c 3))
(println (hash-set 1 1 2 3 4 4))

;; # Exercise 2
(println "------------------------------- Exercise 2 -------------------------------")
(defn add-100 [x]
  (+ x 100))
(println (add-100 10))


;; Exercise 3
(println "------------------------------- Exercise 3 -------------------------------")
(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))
(def inc3 (inc-maker 3))
(println (inc3 7))

(defn dec-maker
  "Custom decrementor"
  [dec-by]
  #(- % dec-by))
(def dec9 (dec-maker 9))
(println (dec9 10))

(println "------------------------------- Exercise 4 -------------------------------")
(defn mapset [f col]
  (set (map f col)))
(println (mapset inc [1 1 2 2]))
(println (mapset inc [1]))
(println (mapset inc [1 1 4 4 4 4 2 2]))
; => #{2 3}


(println "------------------------------- Exercise 5 -------------------------------")
(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])


(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})


(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))


(let [sym-body-parts (symmetrize-body-parts asym-hobbit-body-parts)]
  (println sym-body-parts))

(defn create-radial-symmetry
  [part n]
  {:name (clojure.string/replace (:name part) #"^left-" "")
   :size n})

(defn radial-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)

      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (create-radial-symmetry part 5)])))))))




(println "> Updated body parts:")
(let [radial-body-parts (radial-body-parts asym-hobbit-body-parts)]
  (println radial-body-parts))



(def left-arm {:name "left-arm" :size 3})
(println (left-arm))