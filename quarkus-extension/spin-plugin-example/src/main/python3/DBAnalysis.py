import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import sqlite3

conn = sqlite3.connect('./database.db')

df = pd.read_sql("""SELECT  rental.rental_id, rental.rental_date, (...),
                            customer.last_name AS customer_lastname, store.store_id,
                            city.city AS rental_store_city, film.title AS film_title
                    FROM rental
                    INNER JOIN cutomer ON rental.cutomer_id == cutomer.customer.customer_id
                    INNER JOIN city ON address.city_id == city.city_id
                    """, conn, index_col='rental_id', parse_dates=['rental_date', 'return_date']
                )
df.shape()