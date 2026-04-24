export interface Banner {
  titulo: string;
  subtitulo: string;
  logo: string;
}

export interface Sobre {
  historia: string;
  valores: string;
  equipe: string;
  imagem: string;
}

export interface Categoria {
  id: number;
  nome: string;
  descricao: string;
  imagem: string;
}

export interface Produto {
  nome: string;
  descricao: string;
  preco: string;
  imagem: string;
}

export interface Faq {
  id: number;
  pergunta: string;
  resposta: string;
}

export interface Contato {
  id: number;
  nome: string;
  email: string;
  mensagem: string;
  dataEnvio: string;
}