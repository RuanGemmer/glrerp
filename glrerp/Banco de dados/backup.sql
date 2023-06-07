PGDMP                         {            erp    15.1    15.1 9    ;           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            <           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            =           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            >           1262    17091    erp    DATABASE     z   CREATE DATABASE erp WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE erp;
                postgres    false            �            1255    17349 "   calcular_estoque_vendaorproducao()    FUNCTION     B  CREATE FUNCTION public.calcular_estoque_vendaorproducao() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
  IF NEW.tipo = 'venda' OR NEW.tipo = 'producao' THEN
    UPDATE item
    SET qtde_estoque = item.qtde_estoque + NEW.qtde
    WHERE item.id = NEW.item_id AND item.ativo = true;
  END IF;

  RETURN NEW;
END;
$$;
 9   DROP FUNCTION public.calcular_estoque_vendaorproducao();
       public          postgres    false            �            1255    17347    calcular_valor_estoque()    FUNCTION     �  CREATE FUNCTION public.calcular_valor_estoque() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
  IF NEW.tipo = 'compra' THEN
    UPDATE item
    SET valor = (
        (item.qtde_estoque * item.valor + NEW.qtde * NEW.valor)
        / (item.qtde_estoque + NEW.qtde)
      ),
      qtde_estoque = item.qtde_estoque + NEW.qtde
    WHERE item.id = NEW.item_id AND item.ativo = true;
  END IF;

  RETURN NEW;
END;
$$;
 /   DROP FUNCTION public.calcular_valor_estoque();
       public          postgres    false            �            1255    17344    calcular_valor_estrutura()    FUNCTION     H  CREATE FUNCTION public.calcular_valor_estrutura() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
  UPDATE estrutura
  SET valor_estrutura = 
    CASE 
      WHEN estrutura.und_medida = item.unidade_medida THEN item.valor * estrutura.qtde_insumo
      WHEN estrutura.und_medida = item.und_conv1 THEN item.valor * item.conv2 * estrutura.qtde_insumo
      WHEN estrutura.und_medida = item.und_conv2 THEN item.valor / item.conv2 * estrutura.qtde_insumo
    END
  FROM item
  WHERE estrutura.insumo_id = item.id AND estrutura.ativo=true AND item.id = NEW.id;

  RETURN NEW;
END;
$$;
 1   DROP FUNCTION public.calcular_valor_estrutura();
       public          postgres    false            �            1259    17240    cliente    TABLE     M  CREATE TABLE public.cliente (
    id integer NOT NULL,
    nome character varying(150) NOT NULL,
    cpf character varying(45) NOT NULL,
    email character varying(150) NOT NULL,
    telefone character varying(45) NOT NULL,
    endereco character varying(250),
    tipo character varying(45) NOT NULL,
    ativo boolean NOT NULL
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            �            1259    17239    cliente_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cliente_id_seq;
       public          postgres    false    215            ?           0    0    cliente_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;
          public          postgres    false    214            �            1259    17275 	   estrutura    TABLE     �   CREATE TABLE public.estrutura (
    item_id integer NOT NULL,
    insumo_id integer NOT NULL,
    qtde_insumo double precision NOT NULL,
    ativo boolean NOT NULL,
    und_medida character varying(45) NOT NULL,
    valor_estrutura numeric(10,2)
);
    DROP TABLE public.estrutura;
       public         heap    postgres    false            �            1259    17256    grupo    TABLE     �   CREATE TABLE public.grupo (
    id integer NOT NULL,
    descricao character varying(100) NOT NULL,
    tipo character varying(45) NOT NULL,
    ativo boolean NOT NULL
);
    DROP TABLE public.grupo;
       public         heap    postgres    false            �            1259    17255    grupo_id_seq    SEQUENCE     �   CREATE SEQUENCE public.grupo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.grupo_id_seq;
       public          postgres    false    219            @           0    0    grupo_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.grupo_id_seq OWNED BY public.grupo.id;
          public          postgres    false    218            �            1259    17263    item    TABLE     �  CREATE TABLE public.item (
    id integer NOT NULL,
    id_grupo integer NOT NULL,
    descricao character varying(150) NOT NULL,
    qtde_estoque double precision NOT NULL,
    ativo boolean NOT NULL,
    unidade_medida character varying(45) NOT NULL,
    observacao text,
    conv1 double precision,
    und_conv1 character varying(45),
    conv2 double precision,
    und_conv2 character varying(45),
    valor numeric(10,2) NOT NULL,
    qtde_estoque_min double precision
);
    DROP TABLE public.item;
       public         heap    postgres    false            �            1259    17262    item_id_seq    SEQUENCE     �   CREATE SEQUENCE public.item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.item_id_seq;
       public          postgres    false    221            A           0    0    item_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.item_id_seq OWNED BY public.item.id;
          public          postgres    false    220            �            1259    17292    movimentacao    TABLE     �  CREATE TABLE public.movimentacao (
    id integer NOT NULL,
    tipo character varying(45) NOT NULL,
    data timestamp without time zone NOT NULL,
    item_id integer NOT NULL,
    cliente_id integer,
    valor numeric(10,2) NOT NULL,
    qtde double precision NOT NULL,
    perda double precision NOT NULL,
    observacao character varying(500),
    id_pedido integer,
    id_grupo_movimentacao integer NOT NULL
);
     DROP TABLE public.movimentacao;
       public         heap    postgres    false            �            1259    17291    movimentacao_id_seq    SEQUENCE     �   CREATE SEQUENCE public.movimentacao_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.movimentacao_id_seq;
       public          postgres    false    224            B           0    0    movimentacao_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.movimentacao_id_seq OWNED BY public.movimentacao.id;
          public          postgres    false    223            �            1259    17310    movimentacao_usuario    TABLE     t   CREATE TABLE public.movimentacao_usuario (
    movimentacao_id integer NOT NULL,
    usuario_id integer NOT NULL
);
 (   DROP TABLE public.movimentacao_usuario;
       public         heap    postgres    false            �            1259    17249    usuario    TABLE       CREATE TABLE public.usuario (
    id integer NOT NULL,
    nome character varying(150) NOT NULL,
    senha character varying(150) NOT NULL,
    hierarquia character varying(45) NOT NULL,
    ativo boolean NOT NULL,
    email character varying(150) NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    17248    usuario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.usuario_id_seq;
       public          postgres    false    217            C           0    0    usuario_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;
          public          postgres    false    216            �           2604    17243 
   cliente id    DEFAULT     h   ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);
 9   ALTER TABLE public.cliente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            �           2604    17259    grupo id    DEFAULT     d   ALTER TABLE ONLY public.grupo ALTER COLUMN id SET DEFAULT nextval('public.grupo_id_seq'::regclass);
 7   ALTER TABLE public.grupo ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    219    219            �           2604    17266    item id    DEFAULT     b   ALTER TABLE ONLY public.item ALTER COLUMN id SET DEFAULT nextval('public.item_id_seq'::regclass);
 6   ALTER TABLE public.item ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    221    220    221            �           2604    17295    movimentacao id    DEFAULT     r   ALTER TABLE ONLY public.movimentacao ALTER COLUMN id SET DEFAULT nextval('public.movimentacao_id_seq'::regclass);
 >   ALTER TABLE public.movimentacao ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    223    224            �           2604    17252 
   usuario id    DEFAULT     h   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217            .          0    17240    cliente 
   TABLE DATA           X   COPY public.cliente (id, nome, cpf, email, telefone, endereco, tipo, ativo) FROM stdin;
    public          postgres    false    215   mH       5          0    17275 	   estrutura 
   TABLE DATA           h   COPY public.estrutura (item_id, insumo_id, qtde_insumo, ativo, und_medida, valor_estrutura) FROM stdin;
    public          postgres    false    222   �J       2          0    17256    grupo 
   TABLE DATA           ;   COPY public.grupo (id, descricao, tipo, ativo) FROM stdin;
    public          postgres    false    219   �K       4          0    17263    item 
   TABLE DATA           �   COPY public.item (id, id_grupo, descricao, qtde_estoque, ativo, unidade_medida, observacao, conv1, und_conv1, conv2, und_conv2, valor, qtde_estoque_min) FROM stdin;
    public          postgres    false    221    L       7          0    17292    movimentacao 
   TABLE DATA           �   COPY public.movimentacao (id, tipo, data, item_id, cliente_id, valor, qtde, perda, observacao, id_pedido, id_grupo_movimentacao) FROM stdin;
    public          postgres    false    224   nM       8          0    17310    movimentacao_usuario 
   TABLE DATA           K   COPY public.movimentacao_usuario (movimentacao_id, usuario_id) FROM stdin;
    public          postgres    false    225   �N       0          0    17249    usuario 
   TABLE DATA           L   COPY public.usuario (id, nome, senha, hierarquia, ativo, email) FROM stdin;
    public          postgres    false    217   �N       D           0    0    cliente_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.cliente_id_seq', 10, true);
          public          postgres    false    214            E           0    0    grupo_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.grupo_id_seq', 5, true);
          public          postgres    false    218            F           0    0    item_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.item_id_seq', 25, true);
          public          postgres    false    220            G           0    0    movimentacao_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.movimentacao_id_seq', 30, true);
          public          postgres    false    223            H           0    0    usuario_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuario_id_seq', 22, true);
          public          postgres    false    216            �           2606    17247    cliente cliente_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    215            �           2606    17261    grupo grupo_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.grupo
    ADD CONSTRAINT grupo_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.grupo DROP CONSTRAINT grupo_pkey;
       public            postgres    false    219            �           2606    17268    item item_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.item DROP CONSTRAINT item_pkey;
       public            postgres    false    221            �           2606    17299    movimentacao movimentacao_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.movimentacao
    ADD CONSTRAINT movimentacao_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.movimentacao DROP CONSTRAINT movimentacao_pkey;
       public            postgres    false    224            �           2606    17314 .   movimentacao_usuario movimentacao_usuario_pkey 
   CONSTRAINT     y   ALTER TABLE ONLY public.movimentacao_usuario
    ADD CONSTRAINT movimentacao_usuario_pkey PRIMARY KEY (movimentacao_id);
 X   ALTER TABLE ONLY public.movimentacao_usuario DROP CONSTRAINT movimentacao_usuario_pkey;
       public            postgres    false    225            �           2606    17254    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    217            �           2620    17348 $   movimentacao atualizar_valor_estoque    TRIGGER     �   CREATE TRIGGER atualizar_valor_estoque AFTER INSERT ON public.movimentacao FOR EACH ROW EXECUTE FUNCTION public.calcular_valor_estoque();
 =   DROP TRIGGER atualizar_valor_estoque ON public.movimentacao;
       public          postgres    false    224    227            �           2620    17346    item atualizar_valor_estrutura    TRIGGER     �   CREATE TRIGGER atualizar_valor_estrutura AFTER UPDATE ON public.item FOR EACH ROW EXECUTE FUNCTION public.calcular_valor_estrutura();
 7   DROP TRIGGER atualizar_valor_estrutura ON public.item;
       public          postgres    false    226    221            �           2620    17350 -   movimentacao calcular_estoque_vendaorproducao    TRIGGER     �   CREATE TRIGGER calcular_estoque_vendaorproducao AFTER INSERT ON public.movimentacao FOR EACH ROW EXECUTE FUNCTION public.calcular_estoque_vendaorproducao();
 F   DROP TRIGGER calcular_estoque_vendaorproducao ON public.movimentacao;
       public          postgres    false    228    224            �           2606    17305    movimentacao fk_cliente_id    FK CONSTRAINT     ~   ALTER TABLE ONLY public.movimentacao
    ADD CONSTRAINT fk_cliente_id FOREIGN KEY (cliente_id) REFERENCES public.cliente(id);
 D   ALTER TABLE ONLY public.movimentacao DROP CONSTRAINT fk_cliente_id;
       public          postgres    false    224    215    3210            �           2606    17269    item fk_id_grupo    FK CONSTRAINT     p   ALTER TABLE ONLY public.item
    ADD CONSTRAINT fk_id_grupo FOREIGN KEY (id_grupo) REFERENCES public.grupo(id);
 :   ALTER TABLE ONLY public.item DROP CONSTRAINT fk_id_grupo;
       public          postgres    false    221    219    3214            �           2606    17286    estrutura fk_insumo_id    FK CONSTRAINT     v   ALTER TABLE ONLY public.estrutura
    ADD CONSTRAINT fk_insumo_id FOREIGN KEY (insumo_id) REFERENCES public.item(id);
 @   ALTER TABLE ONLY public.estrutura DROP CONSTRAINT fk_insumo_id;
       public          postgres    false    222    3216    221            �           2606    17281    estrutura fk_item_id    FK CONSTRAINT     r   ALTER TABLE ONLY public.estrutura
    ADD CONSTRAINT fk_item_id FOREIGN KEY (item_id) REFERENCES public.item(id);
 >   ALTER TABLE ONLY public.estrutura DROP CONSTRAINT fk_item_id;
       public          postgres    false    222    221    3216            �           2606    17300    movimentacao fk_item_id    FK CONSTRAINT     u   ALTER TABLE ONLY public.movimentacao
    ADD CONSTRAINT fk_item_id FOREIGN KEY (item_id) REFERENCES public.item(id);
 A   ALTER TABLE ONLY public.movimentacao DROP CONSTRAINT fk_item_id;
       public          postgres    false    221    3216    224            �           2606    17315 '   movimentacao_usuario fk_movimentacao_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.movimentacao_usuario
    ADD CONSTRAINT fk_movimentacao_id FOREIGN KEY (movimentacao_id) REFERENCES public.movimentacao(id);
 Q   ALTER TABLE ONLY public.movimentacao_usuario DROP CONSTRAINT fk_movimentacao_id;
       public          postgres    false    224    225    3218            �           2606    17320 "   movimentacao_usuario fk_usuario_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.movimentacao_usuario
    ADD CONSTRAINT fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);
 L   ALTER TABLE ONLY public.movimentacao_usuario DROP CONSTRAINT fk_usuario_id;
       public          postgres    false    225    3212    217            .   D  x�u��N�0��ӧ�c'���0�KS�18Mh/��RT)���m���(��Nv���+�l�7�L̚���H��>U��Nph��7Us��-�U� 1�b!��9�'J����1ɪ���i�}�����k��0sƑ�-��#.���6��mN 3>-
C�4[���+Z(ʴ�2a�bp�9�_�n7������O$Q(|"p�»��GjEr�t�c)�s0����O 	s�&'7�~�:rf�w�) 	)S1M�:f�� f�u'U��v=z��+\r�<�ɅYZo�su۴�zU�4-�r87�>���ܧ�%2�֧�) $�RQ�X�4���vSo�$���b���.	��9s��w23���L��4��1	�JH���͖�X�ZQ�hb��z]��v=D���� �Xǻk"����˷%�;�st��FZP-��!l��栵b`��67g���Z�p�]\�&K�tL0��T23���c&ag '��^���W�$�TrICd5��j���z �c�)�E/Qt����;Ţ��8�Zfb3G�f2E"r��c	�BF���	`���mC���o 욠��5�w����h��g �      5   �   x�}�A�0��+x�;uR��	��
��Ni���u�ٵ7�b�����u<�@;RI�Tx�'H襠 �A��w�(��(����%���Q���l~J�G*Y��m��HR��-s��r�5'v���5�Iyj=�K\!]��W�2����c������q��{��gO      2   n   x�e�1�0F���)r)p 7��r��k�*!��p�^������E�����i�h���A٥�L�(��.�d1ޒ����4q��Z��'9����n.���ٯ+���      4   ^  x�u��N�@��w�b��p2s��t9�I(C��0��M�6Qkt�#�H}1/�ʂ\�wg�A�PFE�2<�}�����x��R(x߭��d�2Ԡ!����J���2�K(	��nC� �DP��K�"<|g��$�_�eQٰ8��&
)z�.����G�a<w��i�u���bx'W��q�j]�f3���̟���zY�L�����M������@�h$6�-+I~IC7�)>2�0s��˵���z���_�,�E�$B!wG��o����u'���r<K�Wmh����?��PSz��3�	��B�LMN[�h�G�6��C��}g�����+��z��      7   L  x���]n�0�g�\���|4�!v^�q!m矓�]?(�@H?�'�޿����u�N<F�H��K��B@�/[��=���I�~͂1���K����ϰT�����-`#O0`]/:)B�-<�����r�(�����T?	����>�ɍFM�����"�J2�$�9�)ġ�[M棕]2S�y����3P46�?�`B�N�аCR�~�졓"�#��o�iDm�@��^AB(�à��;	���K�Z��֔�o!q�x��8:L/�ڭ*[�o�������9�A�9�����$����)J�@'�<W7��v�Vh5|NnR�� �%��      8      x������ � �      0     x�]��r�0�ux�.XG����D�%U	02�M��H%D������v}Ϝ�\��t�
��7L�2���ȏ+Z����.����iB�sʻz`�خ�g�{<É_��b�*����8���LR��x�
���ᶑ������C�-�9��ߔ,N/g|���0�m�gE7�W�Yj{��i��AHB���h=N۔��8!������UE:Kx��̴�3�8L�J�e��;c�t�d0�E'�	�wH�Y~���;1
��(I���l�     