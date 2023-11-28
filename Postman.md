
Тест для /api/v1/all-warehouse (GET запрос для получения всех складов):

json
// Проверка успешного ответа и наличия данных
pm.test("Status code is 200", function () {
pm.response.to.have.status(200);
});

pm.test("Response should be an array", function () {
pm.response.to.be.json;
pm.response.to.have.body('response', true);
pm.response.to.have.jsonBody('data', pm => pm.length > 0);
});
Тест для /api/v1/warehouse-cell (POST запрос для получения ячеек склада):

json
// Проверка успешного ответа и наличия данных
pm.test("Status code is 200", function () {
pm.response.to.have.status(200);
});

pm.test("Response should be an array", function () {
pm.response.to.be.json;
pm.response.to.have.body('response', true);
pm.response.to.have.jsonBody('data', pm => pm.length > 0);
});
Тест для /api/v1/warehouse-cell с передачей параметра (POST запрос для получения ячеек склада с указанием idWarehouse):

json
// Задаем переменную существующего idWarehouse
const existingWarehouseId = 1;

pm.test("Status code is 200", function () {
pm.response.to.have.status(200);
});

pm.test("Response should be an array", function () {
pm.response.to.be.json;
pm.response.to.have.body('response', true);
pm.response.to.have.jsonBody('data', pm => pm.length > 0);
});