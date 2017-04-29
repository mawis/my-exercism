(ns space-age)

(def earth-year 31557600)

(defn on-earth [sec]
  (/ sec earth-year))

(defn- relative-to-earth [scale sec]
  (/ (on-earth sec) scale))

(defmacro age-divisor [func divisor]
  `(def ~func (partial relative-to-earth ~divisor)))

(age-divisor on-mercury 0.2408465)
(age-divisor on-venus   0.61519726)
(age-divisor on-mars    1.8808158)
(age-divisor on-jupiter 11.862615)
(age-divisor on-saturn  29.447498)
(age-divisor on-uranus  84.016846)
(age-divisor on-neptune 164.79132)
