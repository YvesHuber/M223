
INSERT INTO public."USER" (
id, "Email", "Nachname", "Passwort", "Role", "Vorname") VALUES (
'1'::bigint, 'Test@Admin.test'::character varying, 'Huber'::character varying, '123456'::character varying, 'Admin'::character varying, 'Yves'::character varying)
 returning id;

 INSERT INTO public."USER" (
id, "Email", "Nachname", "Passwort", "Role", "Vorname") VALUES (
'2'::bigint, 'Test@Mitglied.test'::character varying, 'Machaz'::character varying, '123456'::character varying, 'Mitglied'::character varying, 'Severin'::character varying)
 returning id;


INSERT INTO public."BUCHUNG" (
id, "Datum", "Halbtag", "Status", "Visablility", user_id) VALUES (
'1'::bigint, '2022-09-26'::date, false::boolean, 'Accepted'::character varying, true::boolean, '1'::bigint)
 returning id;

 INSERT INTO public."BUCHUNG" (
id, "Datum", "Halbtag", "Status", "Visablility", user_id) VALUES (
'2'::bigint, '2022-09-26'::date, false::boolean, 'Accepted'::character varying, false::boolean, '2'::bigint)
 returning id;