INSERT INTO garage (city, street, building, capacity, name)
VALUES ('Minsk', 'Lenina', '13A', 50, 'Luxury car'),
       ('Brest', 'Skariny', '27', 60, 'Diamond'),
       ('Vitebsk', 'Pobeda', '66B', 33, 'Safe car 24/7');

INSERT INTO car (vin_code, brand, model, year_issue, colour, seats_quantity, garage_id)
VALUES ('11111AA', 'Volkswagen', 'Polo', 2020, 'white', 5,
        (SELECT id FROM garage WHERE name = 'Safe car 24/7')),
       ('22222BB', 'Volkswagen', 'Golf', 2021, 'red', 5,
        (SELECT id FROM garage WHERE name = 'Safe car 24/7')),
       ('33333SS', 'Mazda', '3', 2022, 'black', 5,
        (SELECT id FROM garage WHERE name = 'Safe car 24/7')),
       ('35689QQ', 'BMW', '530', 2020, 'white', 5,
        (SELECT id FROM garage WHERE name = 'Safe car 24/7')),
       ('QW89564', 'Mercedes', 'E', 2021, 'black', 5,
        (SELECT id FROM garage WHERE name = 'Diamond')),
       ('RT48968', 'Audi', 'A5', 2022, 'blue', 5,
        (SELECT id FROM garage WHERE name = 'Diamond')),
       ('LK25674', 'Mercedes', 'Maybach', 2022, 'black', 5,
        (SELECT id FROM garage WHERE name = 'Diamond')),
       ('PO65324', 'Rolls-Royce', 'Ghost', 2021, 'black', 5,
        (SELECT id FROM garage WHERE name = 'Luxury car')),
       ('UY45873', 'Mercedes', 'V', 2020, 'white', 6,
        (SELECT id FROM garage WHERE name = 'Luxury car'));