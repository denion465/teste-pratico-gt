import styled from 'styled-components';

import formBackgroundImg from '../../assets/form-backroung.jpg';

export const Container = styled.div`
  height: 100vh;
  display: flex;
  align-items: stretch;
`;

export const Content = styled.div`
  display: flex;
  flex-direction: column;

  align-items: center;

  place-content: center;

  width: 100%;
  max-width: 800px;

  form {
    margin-left: 50px;
  }

  input {
    width: 100%;
    width: 400px;
    display: flex;
    margin: 15px;
    padding: 2px;
  }

  button {
    width: 460px;
  }
`;

export const Background = styled.div`
  flex: 1;
  background: url(${formBackgroundImg}) black no-repeat center;
  background-size: cover;
`;
