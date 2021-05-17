import styled from 'styled-components';

import backgroundPng from '../../assets/background.jpg';

export const Container = styled.div`
  height: 100vh;

  display: flex;
  align-items: stretch;
`;

export const Content = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;

  margin-top: 20vh;

  width: 100%;
  max-width: 800px;

  form {
    width: 340px;
    text-align: center;
  }

  button {
    width: 460px;
  }

  img {
    margin-left: 100px;
    width: 25%;
  }
`;

export const Background = styled.div`
  flex: 1;
  background: url(${backgroundPng}) no-repeat center;
  background-size: cover;
`;
