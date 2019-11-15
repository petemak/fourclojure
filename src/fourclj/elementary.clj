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
(= 8 ((fn [x] (+ x 5)) 3))
(= 8 ((partial + 5) 3))


;; #15 Double Down
(= ((fn double-num [x] (* x 2)) 4))
(= ((fn [x] (* x 2) 3) 6))
(= (#(* % 2) 11) 22)
(= ((partial * 2) 7) 14)
