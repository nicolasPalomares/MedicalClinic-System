PGDMP                      |            medical_clinic_system    16.2    16.2 :    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                        0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16510    medical_clinic_system    DATABASE     �   CREATE DATABASE medical_clinic_system WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Argentina.1252';
 %   DROP DATABASE medical_clinic_system;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                pg_database_owner    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   pg_database_owner    false    4            �            1259    16512    address    TABLE     e   CREATE TABLE public.address (
    address_id bigint NOT NULL,
    street text,
    street_no text
);
    DROP TABLE public.address;
       public         heap    postgres    false    4            �            1259    16511    address_address_id_seq    SEQUENCE     �   ALTER TABLE public.address ALTER COLUMN address_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.address_address_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216    4            �            1259    16580    appointment    TABLE     �   CREATE TABLE public.appointment (
    appointment_id bigint NOT NULL,
    client_id bigint,
    doctor_id bigint,
    date text,
    "time" text
);
    DROP TABLE public.appointment;
       public         heap    postgres    false    4            �            1259    16579    appointment_appointment_id_seq    SEQUENCE     �   ALTER TABLE public.appointment ALTER COLUMN appointment_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.appointment_appointment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    4    228            �            1259    16528    client    TABLE     �   CREATE TABLE public.client (
    client_id bigint NOT NULL,
    name text,
    surname text,
    address_id bigint,
    contact_id bigint,
    life_insurance_type text
);
    DROP TABLE public.client;
       public         heap    postgres    false    4            �            1259    16527    client_client_id_seq    SEQUENCE     �   ALTER TABLE public.client ALTER COLUMN client_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.client_client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    220    4            �            1259    16520    contact    TABLE     g   CREATE TABLE public.contact (
    contact_id bigint NOT NULL,
    phone_number text,
    email text
);
    DROP TABLE public.contact;
       public         heap    postgres    false    4            �            1259    16519    contact_contact_id_seq    SEQUENCE     �   ALTER TABLE public.contact ALTER COLUMN contact_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.contact_contact_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    218    4            �            1259    16554 
   department    TABLE     x   CREATE TABLE public.department (
    department_id bigint NOT NULL,
    office_no text,
    specialization_id bigint
);
    DROP TABLE public.department;
       public         heap    postgres    false    4            �            1259    16553    department_department_id_seq    SEQUENCE     �   ALTER TABLE public.department ALTER COLUMN department_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.department_department_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    224    4            �            1259    16567    doctor    TABLE     y   CREATE TABLE public.doctor (
    doctor_id bigint NOT NULL,
    name text,
    surname text,
    department_id bigint
);
    DROP TABLE public.doctor;
       public         heap    postgres    false    4            �            1259    16566    doctor_doctor_id_seq    SEQUENCE     �   ALTER TABLE public.doctor ALTER COLUMN doctor_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.doctor_doctor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    4    226            �            1259    16604    role    TABLE     ]   CREATE TABLE public.role (
    role_id bigint NOT NULL,
    name text,
    user_id bigint
);
    DROP TABLE public.role;
       public         heap    postgres    false    4            �            1259    16603    role_role_id_seq    SEQUENCE     �   ALTER TABLE public.role ALTER COLUMN role_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.role_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    232    4            �            1259    16546    specialization    TABLE     r   CREATE TABLE public.specialization (
    specialization_id bigint NOT NULL,
    name text,
    services text[]
);
 "   DROP TABLE public.specialization;
       public         heap    postgres    false    4            �            1259    16545 $   specialization_specialization_id_seq    SEQUENCE     �   ALTER TABLE public.specialization ALTER COLUMN specialization_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.specialization_specialization_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    222    4            �            1259    16596    user_entity    TABLE     g   CREATE TABLE public.user_entity (
    user_id bigint NOT NULL,
    username text,
    password text
);
    DROP TABLE public.user_entity;
       public         heap    postgres    false    4            �            1259    16595    user_entity_user_id_seq    SEQUENCE     �   ALTER TABLE public.user_entity ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_entity_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    4    230            �          0    16512    address 
   TABLE DATA                 public          postgres    false    216   +?       �          0    16580    appointment 
   TABLE DATA                 public          postgres    false    228   �?       �          0    16528    client 
   TABLE DATA                 public          postgres    false    220   C@       �          0    16520    contact 
   TABLE DATA                 public          postgres    false    218   A       �          0    16554 
   department 
   TABLE DATA                 public          postgres    false    224   �A       �          0    16567    doctor 
   TABLE DATA                 public          postgres    false    226   ?B       �          0    16604    role 
   TABLE DATA                 public          postgres    false    232   �B       �          0    16546    specialization 
   TABLE DATA                 public          postgres    false    222   C       �          0    16596    user_entity 
   TABLE DATA                 public          postgres    false    230   �C                  0    0    address_address_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.address_address_id_seq', 5, true);
          public          postgres    false    215                       0    0    appointment_appointment_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.appointment_appointment_id_seq', 7, true);
          public          postgres    false    227                       0    0    client_client_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.client_client_id_seq', 5, true);
          public          postgres    false    219                       0    0    contact_contact_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.contact_contact_id_seq', 5, true);
          public          postgres    false    217                       0    0    department_department_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.department_department_id_seq', 3, true);
          public          postgres    false    223                       0    0    doctor_doctor_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.doctor_doctor_id_seq', 1, true);
          public          postgres    false    225            	           0    0    role_role_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.role_role_id_seq', 3, true);
          public          postgres    false    231            
           0    0 $   specialization_specialization_id_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public.specialization_specialization_id_seq', 9, true);
          public          postgres    false    221                       0    0    user_entity_user_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.user_entity_user_id_seq', 2, true);
          public          postgres    false    229            C           2606    16518    address address_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (address_id);
 >   ALTER TABLE ONLY public.address DROP CONSTRAINT address_pkey;
       public            postgres    false    216            O           2606    16584    appointment appointment_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT appointment_pkey PRIMARY KEY (appointment_id);
 F   ALTER TABLE ONLY public.appointment DROP CONSTRAINT appointment_pkey;
       public            postgres    false    228            G           2606    16534    client client_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (client_id);
 <   ALTER TABLE ONLY public.client DROP CONSTRAINT client_pkey;
       public            postgres    false    220            E           2606    16526    contact contact_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.contact
    ADD CONSTRAINT contact_pkey PRIMARY KEY (contact_id);
 >   ALTER TABLE ONLY public.contact DROP CONSTRAINT contact_pkey;
       public            postgres    false    218            K           2606    16560    department department_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (department_id);
 D   ALTER TABLE ONLY public.department DROP CONSTRAINT department_pkey;
       public            postgres    false    224            M           2606    16573    doctor doctor_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.doctor
    ADD CONSTRAINT doctor_pkey PRIMARY KEY (doctor_id);
 <   ALTER TABLE ONLY public.doctor DROP CONSTRAINT doctor_pkey;
       public            postgres    false    226            S           2606    16610    role role_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (role_id);
 8   ALTER TABLE ONLY public.role DROP CONSTRAINT role_pkey;
       public            postgres    false    232            I           2606    16552 "   specialization specialization_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.specialization
    ADD CONSTRAINT specialization_pkey PRIMARY KEY (specialization_id);
 L   ALTER TABLE ONLY public.specialization DROP CONSTRAINT specialization_pkey;
       public            postgres    false    222            Q           2606    16602    user_entity user_entity_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.user_entity
    ADD CONSTRAINT user_entity_pkey PRIMARY KEY (user_id);
 F   ALTER TABLE ONLY public.user_entity DROP CONSTRAINT user_entity_pkey;
       public            postgres    false    230            T           2606    16535    client address_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.client
    ADD CONSTRAINT address_id_fkey FOREIGN KEY (address_id) REFERENCES public.address(address_id) NOT VALID;
 @   ALTER TABLE ONLY public.client DROP CONSTRAINT address_id_fkey;
       public          postgres    false    216    220    4675            X           2606    16585    appointment client_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT client_id_fkey FOREIGN KEY (client_id) REFERENCES public.client(client_id) NOT VALID;
 D   ALTER TABLE ONLY public.appointment DROP CONSTRAINT client_id_fkey;
       public          postgres    false    4679    220    228            U           2606    16540    client contact_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.client
    ADD CONSTRAINT contact_id_fkey FOREIGN KEY (contact_id) REFERENCES public.contact(contact_id) NOT VALID;
 @   ALTER TABLE ONLY public.client DROP CONSTRAINT contact_id_fkey;
       public          postgres    false    220    4677    218            W           2606    16574    doctor department_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.doctor
    ADD CONSTRAINT department_id_fkey FOREIGN KEY (department_id) REFERENCES public.department(department_id) NOT VALID;
 C   ALTER TABLE ONLY public.doctor DROP CONSTRAINT department_id_fkey;
       public          postgres    false    224    4683    226            Y           2606    16590    appointment doctor_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT doctor_id_fkey FOREIGN KEY (doctor_id) REFERENCES public.doctor(doctor_id) NOT VALID;
 D   ALTER TABLE ONLY public.appointment DROP CONSTRAINT doctor_id_fkey;
       public          postgres    false    228    4685    226            V           2606    16561 !   department specialization_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.department
    ADD CONSTRAINT specialization_id_fkey FOREIGN KEY (specialization_id) REFERENCES public.specialization(specialization_id) NOT VALID;
 K   ALTER TABLE ONLY public.department DROP CONSTRAINT specialization_id_fkey;
       public          postgres    false    222    224    4681            Z           2606    16611    role user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.role
    ADD CONSTRAINT user_id_fkey FOREIGN KEY (user_id) REFERENCES public.user_entity(user_id) NOT VALID;
 ;   ALTER TABLE ONLY public.role DROP CONSTRAINT user_id_fkey;
       public          postgres    false    232    4689    230            �   �   x���v
Q���W((M��L�KLI)J-.V�s
�t��sW�q�Us�	u���
�:
�~�%�y���@������5�'�&M�*-�,I-hiaN���@S�KJ��N444��D�)��E`���)u�)�}�y ��N�� Mq�      �   d   x���v
Q���W((M��L�K,(���+�M�+Q�s
�t��sW�q�Us�	u���
�:
�:
�:
�FF&���FF�@��������5 �&~      �   �   x���A
�0D�=��EA��t��P"�JS.cj!4�4.<�I`a�3�7�!�M�jkxڻ���QL3�nR��z�->C����{)����zL�y���8љM=�=Z�"�7>u���̾� �.�A�Tr!>�P��2_Z�b����=3#_֐�}���A��ۅ$��} �dk�      �   �   x���O�0�b7"��F�GJCM��0C3�u��7�K����~��+�L�9�q���=ו^��6(=��i*#oAv�r��fw���\ B�0&�w��fݨ�vB��W���F�JÐ��}0�yN���rB�QW����M���*�c9g���s��.S��cG]��<T�~|�{r��      �   f   x���v
Q���W((M��L�KI-H,*�M�+Q�s
�t��sW�q�Us�	u���
�:
�F��:
f��\�e2
h��&M� �d4�� 6R?�      �   X   x���v
Q���W((M��L�K�O.�/R�s
�t��sW�q�Us�	u���
�:
��E���E��@�G~iq*�a�i��� ���      �   e   x���v
Q���W((M��L�+��IU�s
�t��sW�q�Us�	u���
�:
�A�>��@��:
���\�d�e�f�f��rt����� ��?�      �   �   x���v
Q���W((M��L�+.HM�L�ɬJ,���S�s
�t��sW�q�Us�	u���
f:
�~�E�9���@^�sNf^f�NpiQzjQe���5�'���MvN,Jɤ�=`��bx�J�[M��K�j: vk}W      �   �   x���Ao�0 ��;��\b�rpO��u�b(�체�p�X��+��._��wx0e(��q~���g׋������n ܣ(�[L=�2� ��$A�e`����x�nq���m�/S�:9�������z�����:��*dN�c���#�/+��b=�h��_��:�m�H���y���ŶO���dA]�K�['�ˀU5b4� 6U�     