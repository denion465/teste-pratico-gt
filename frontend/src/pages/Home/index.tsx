import React from 'react';
import { Link } from 'react-router-dom';
import { Container, Content, Background } from './styles';

import logoPng from '../../assets/logo.png';
import Button from '../../components/Button';

const Home: React.FC = () => (
  <Container>
    <Content>
      <img src={logoPng} alt="Logo" />
      <form>
        <Link to="/createpatient">
          <Button type="button">Criar Formulário do paciente</Button>
        </Link>
        <Link to="/map">
          <Button type="button">Mapa</Button>
        </Link>
      </form>
    </Content>

    <Background />
  </Container>
);

export default Home;
