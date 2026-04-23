-- BANNER
INSERT INTO banner (id, logo, titulo, subtitulo)
VALUES (1, 'logo.jpg', 'Café Aroma', 'O despertar perfeito com o sabor autêntico do grão artesanal.');

-- SOBRE
-- Inserindo informações institucionais da Café Aroma
INSERT INTO sobre (id, historia, valores, equipe, imagem)
VALUES (1,
        'Fundada em 2018, a Café Aroma nasceu da paixão por grãos selecionados e pelo desejo de criar um refúgio urbano. O que começou com uma pequena torrefação artesanal hoje é um ponto de encontro para amantes do café.',
        'Priorizamos a sustentabilidade, o apoio a produtores locais e a busca constante pela xícara de café perfeita.',
        'Nossa equipe é formada por baristas certificados e apaixonados pelo que fazem, sempre prontos para contar a história por trás de cada grão.',
        'sobre_nos.jpg'
       );

-- CATEGORIAS
INSERT INTO categoria (id, nome, descricao, imagem)
VALUES (1, 'Cafés', 'Cafés especiais, espressos e bebidas geladas artesanais.', 'cafes.jpg');

INSERT INTO categoria (id, nome, descricao, imagem)
VALUES (2, 'Salgados', 'Salgados assados na hora, quiches e opções integrais.', 'salgados.jpg');

INSERT INTO categoria (id, nome, descricao, imagem)
VALUES (3, 'Doces', 'Doces finos, bolos caseiros e sobremesas irresistíveis.', 'doces.jpg');

-- PRODUTOS
-- Cafés - Categoria 1
INSERT INTO produto (id, nome, descricao, preco, imagem, categoria_id)
VALUES (1, 'Espresso Tradicional', 'Café espresso curto e intenso.', 6.50, 'espresso.jpg', 1);

INSERT INTO produto (id, nome, descricao, preco, imagem, categoria_id)
VALUES (2, 'Cappuccino Cremoso', 'Espresso com leite vaporizado e canela.', 12.00, 'cappuccino.jpg', 1);

INSERT INTO produto (id, nome, descricao, preco, imagem, categoria_id)
VALUES (3, 'Café com Leite Artesanal', 'Proporção equilibrada de café e leite cremoso.', 9.50, 'cafe_leite.jpg', 1);

INSERT INTO produto (id, nome, descricao, preco, imagem, categoria_id)
VALUES (4, 'Cold Brew', 'Café extraído a frio por 12 horas.', 14.00, 'cold_brew.jpg', 1);

-- Salgados & Pães - Categoria 2
INSERT INTO produto (id, nome, descricao, preco, imagem, categoria_id)
VALUES (5, 'Croissant de Queijo', 'Massa folhada com recheio de muçarela.', 11.00, 'croissant.jpg', 2);

INSERT INTO produto (id, nome, descricao, preco, imagem, categoria_id)
VALUES (6, 'Pão de Queijo Recheado', 'Recheado com requeijão cremoso.', 8.00, 'pao_queijo.jpg', 2);

INSERT INTO produto (id, nome, descricao, preco, imagem, categoria_id)
VALUES (7, 'Quiche de Frango', 'Quiche individual com frango e ervas.', 15.50, 'quiche.jpg', 2);

INSERT INTO produto (id, nome, descricao, preco, imagem, categoria_id)
VALUES (8, 'Wrap Integral', 'Frango grelhado, alface e molho especial.', 18.00, 'wrap.jpg', 2);

-- Doces & Bolos - Categoria 3
INSERT INTO produto (id, nome, descricao, preco, imagem, categoria_id)
VALUES (9, 'Fatia de Bolo de Cenoura', 'Com cobertura de chocolate belga.', 10.00, 'bolo_cenoura.jpg', 3);

INSERT INTO produto (id, nome, descricao, preco, imagem, categoria_id)
VALUES (10, 'Brownie de Chocolate', 'Brownie denso com nozes.', 9.00, 'brownie.jpg', 3);

INSERT INTO produto (id, nome, descricao, preco, imagem, categoria_id)
VALUES (11, 'Cheesecake de Frutas Vermelhas', 'Base crocante com calda caseira.', 16.00, 'cheesecake.jpg', 3);

INSERT INTO produto (id, nome, descricao, preco, imagem, categoria_id)
VALUES (12, 'Cookie Artesanal', 'Baunilha com gotas de chocolate meio amargo.', 7.50, 'cookie.jpg', 3);

-- CONTATO
INSERT INTO contato (id, nome, email, mensagem, data_envio)
VALUES (1, 'João Silva', 'joao.silva@email.com', 'Gostaria de saber se vocês aceitam reservas para eventos corporativos.', '2026-04-21 10:30:00');

INSERT INTO contato (id, nome, email, mensagem, data_envio)
VALUES (2, 'Maria Oliveira', 'maria.oliveira@teste.com.br', 'O cappuccino de vocês é sensacional! Parabéns pelo atendimento.', '2026-04-22 15:45:10');

INSERT INTO contato (id, nome, email, mensagem, data_envio)
VALUES (3, 'Carlos Souza', 'carlos.tech@provedor.com', 'Tive um problema com meu pedido pelo app, poderiam me ajudar?', '2026-04-23 09:12:05');

-- FAQ
INSERT INTO faq (id, pergunta, resposta)
VALUES (1, 'Quais são os horários de funcionamento?', 'Estamos abertos de segunda a sábado, das 08:00 às 20:00. Aos domingos, das 09:00 às 15:00.');

INSERT INTO faq (id, pergunta, resposta)
VALUES (2, 'Vocês possuem opções veganas ou sem glúten?', 'Sim! Temos leites vegetais para os cafés e uma seleção de bolos e salgados fit/veganos sinalizados no cardápio.');

INSERT INTO faq (id, pergunta, resposta)
VALUES (3, 'Posso levar meu pet?', 'Com certeza! Somos um estabelecimento Pet Friendly e temos um espaço reservado e confortável para você e seu amigo.');

-- Sincronizando as sequences com os IDs inseridos manualmente
ALTER TABLE banner ALTER COLUMN id RESTART WITH 2;
ALTER TABLE categoria ALTER COLUMN id RESTART WITH 4;
ALTER TABLE produto ALTER COLUMN id RESTART WITH 13;
ALTER TABLE contato ALTER COLUMN id RESTART WITH 4;
ALTER TABLE faq ALTER COLUMN id RESTART WITH 4;
ALTER TABLE sobre ALTER COLUMN id RESTART WITH 2;