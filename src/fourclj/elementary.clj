(ns fourclj.elementary)


;; #9 Sets: conj
(= #{1 2 3 4} (conj #{1 4 3} 2))

;; #10 Intro to maps
(= 20 ((hash-map :a 10 :b 20 :c 30) :b))

(= 20 (:b {:a 10 :b 20 :c 30}))

;; #11 Maps: conj
(= {:a 1 :b 2 :c 3} (conj {:a 1} [:b 2] {:c 3}))
(= {:a 1 :b 2 :c 3 :d 4 :e 5 :f 6 :g 7} (conj {:a 1}  [:b 2] [:c 3] [:d 4] [:e 5] [:f 6] [:g 7]))

;; #12 Intro to Sequences
(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))

;; #13 Sequences: rest
(= [20 30 40] (rest [10 20 30 40]))


;; #14 Intro to Functions
(= 8 ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn [x] (+ x 5)) 
(= 8 ((partial + 5) 3))


;; #15 Double Down
(= ((fn double-num [x] (* x 2)) 
(= ((fn [x] (* x 2) 3) 6))
(= (#(* % 2) 11) 22)
(= ((partial * 2) 7) 14)


;; #16 Hello World
(defn hello
  [n]
  (str "Hello, " n "!"))


;; #17 Sequences: map
(= '(6 7 8) (map #(+ % 5) '(1 2 3)) )


;; #18 Sequences: filter
;; (re-seq #"[ab]+" "A Suburban Addisababa")
;; ("b" "ba" "ababa")
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))



;; #35 Local bindings
(= 7 (let [x 5] (+ 2 x)))
(= 7 (let [x 3 y 10] (- y x)))
(= 7 (let [x 21] (let [y 3] (/ x y))))

;; #36 Let it Be
(= 10 (let [x 7 y 3 z 1] (+ x y)))
(= 4  (let [x 7 y 3 z 1] (+ y z)))
(= 1  (let [x 7 y 3 z 1] z))


;; #37 Regular Expressions
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))


;; #64 Intro to Reduce
(= 15 (reduce + [1 2 3 4 5]))
(= 0 (reduce + []))
(= 6 (reduce + 1 [2 3]))


;; #57 Simple Recursion
;; A recursive function is a function which calls itself.
;; This is one of the fundamental techniques used in functional programming.
(comment
  
  (defn foo
    [x]
    (when (> x 0)
      (conj (foo (dec x)) x)))


  (foo 5))


(= '(5 4 3 2 1) ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))


;; #71 Rearranging Code: ->
 
(= (last (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6]
       (reverse)
       (rest)
       (sort)
       (last)))



;; #68 Recurring Theme
;; Clojure has only one non-stack-consuming looping construct: recur.
;; Either a function or a loop can be used as the recursion point.
;; Either way, recur rebinds the bindings of the recursion point to
;; the values it is passed. Recur must be called from the tail-position,
;; and calling it elsewhere will result in an error.
(= [7 6 5 4 3]
   (loop [x 5
          result []]
     (if (> x 0)
       (recur (dec x) (conj result (+ 2 x)))
       result)))


;; #72 Rearranging Code: ->>
;; The ->> macro threads an expression x through a variable number of forms.
;; First, x is inserted as the last item in the first form, making a list
;; of it if it is not a list already. Then the first form is inserted as
;; the last item in the second form, making a list of that form if necessary.
;; This process continues for all the forms. Using ->> can sometimes make
;; your code more readable.
(= (reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
   (->> [2 5 4 1 3 6]
        (drop 2)
        (take 3)
        (map inc)
        (reduce +)))



;; #134 A nil key
;; Write a function which, given a key and map,
;; returns true iff the map contains an entry with
;; that key and its value is nil.
(defn f134
  [k m]
  (and (contains? m k)
       (nil? (get m k))))

(true? (f134 :a {:a nil :b 2}))
(false? (f134 :b {:a nil :b 2}))
(false? (f134 :c {:a nil :b 2}))


;; #145 For the win
;; Clojure's for macro is a tremendously versatile mechanism for producing
;; a sequence based on some other sequence(s). It can take some time to
;; understand how to use it properly, but that investment will be paid
;; back with clear, concise sequence-wrangling later. With that in mind,
;; read over these for expressions and try to see how each of them produces
;; the same result.

(def results '(1 5 9 13 17 21 25 29 33 37))


(= results (for [x (range 40)
                 :when (= 1 (rem x 4))]
             x))

(= results (for [x (iterate #(+ 4 %) 0)
                 :let [z (inc x)]
                 :while (< z 40)]
             z))


(= results (for [[x y] (partition 2 (range 20))]
             (+ x y)))

;; #162 Logical falsity and truth

(= 1 (if-not false 1 0))
(= 1 (if-not nil 1 0))
(= 1 (if true 1 0))
(= 1 (if [] 1 0))
(= 1 (if [0] 1 0))
(= 1 (if 0 1 0))
(= 1 (if 1 1 0))

;; #52 Intro to Destructuring
;; Let bindings and function parameter lists support destructuring.
    
(= [2 4] (let [[a b c d e] [0 1 2 3 4]]
           [c e]))

;; #61 Subset and Superset
;; Set A is a subset of set B, or equivalently B is a superset of A,
;; if A is "contained" inside B. A and B may coincide.

(clojure.set/superset? #{1 2} #{2})
(clojure.set/subset? #{1} #{1 2})
(clojure.set/superset? #{1 2} #{1 2})
(clojure.set/subset? #{1 2} #{1 2})

# 156
# Map Defaults
# When retrieving values from a map, you can specify default values in case the key is not found:
#
# (= 2 (:foo {:bar 0, :baz 1} 2))
#
# However, what if you want the map itself to contain the default values? Write
    # a function which takes a default value and a sequence of keys and constructs a map.
(defn f156
 [d ks]
 ())
