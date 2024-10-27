--CREATE_CATEGORY
MERGE INTO category(id, name, active, type)
VALUES(1, 'Monitores', true, 'NORMAL');

MERGE INTO category(id, name, active, type)
VALUES(2, 'Tvs', true, 'NORMAL');

MERGE INTO category(id, name, active, type)
VALUES(3, 'Celulares', true, 'NORMAL');

MERGE INTO category(id, name, active, type)
VALUES(4, 'Brinquedos', true, 'NORMAL');