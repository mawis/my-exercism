(ns meetup
  (:import [java.time DayOfWeek LocalDate]))

(def dow {:monday DayOfWeek/MONDAY
          :tuesday DayOfWeek/TUESDAY
          :wednesday DayOfWeek/WEDNESDAY
          :thursday DayOfWeek/THURSDAY
          :friday DayOfWeek/FRIDAY
          :saturday DayOfWeek/SATURDAY
          :sunday DayOfWeek/SUNDAY})

(defn- month [year mon]
  (take-while #(= mon (.getMonthValue %))
              (iterate #(.plusDays % 1) (LocalDate/of year mon 1))))

(defn- date->vec [date]
  [(.getYear date) (.getMonthValue date) (.getDayOfMonth date)])

(defn meetup [mon year wday week]
  (let [days (filter #(= (.getDayOfWeek %) (wday dow))
                     (month year mon))]
    (date->vec
     (case week
       :first (nth days 0)
       :second (nth days 1)
       :third (nth days 2)
       :fourth (nth days 3)
       :last (last days)
       :teenth (first
                (filter #(some #{(.getDayOfMonth %)}
                               (range 13 20))
                        days))))))
