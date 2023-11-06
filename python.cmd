class Sklad(Resource):
    def get(self):
        connection = psycopg2.connect(host='62.217.176.63',
                                      user='postgres',
                                      password='1172922',
                                      database='ozon')
        try:
            with connection.cursor() as cursor:
                cursor.execute("select * from warehouse")
                record_orders = cursor.fetchall()

                json_data = [{
                    "id": id_warehouse,
                    "point_name": point_name,
                    "point_address": point_address,
                    "latitude": float(latitude),
                    "longitude": float(longitude),
                    "count_free_cell": count_free_cell,
                    "url_images": url_images if url_images else [],
                    "schedule": schedule,
                    "big_cell": big_cell,
                    "medium_cell": medium_cell,
                    "small_cell": small_cell
                } for id_warehouse, point_name, point_address, latitude, longitude, count_free_cell, url_images, schedule, big_cell, medium_cell, small_cell in
                    record_orders]
                return json_data
        except Exception as e:
            return {"error": str(e)}, 500
        finally:
            connection.close()