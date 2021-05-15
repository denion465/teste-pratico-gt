import React from 'react';
import { Container, Content, Background } from './styles';

import logoPng from '../../assets/logo.png';
import Button from '../../components/Button';

const Home: React.FC = () => (
  <Container>
    <Content>
      <img src={logoPng} alt="Logo" />
      <form>
        <Button type="submit">Criar Formulário do paciente</Button>
        <Button type="submit">Exibir pacientes cadastrados</Button>
      </form>
    </Content>
    <Background />
  </Container>
);

export default Home;
