import styled from 'styled-components';

import { shade } from 'polished';

export const Container = styled.button`
  background: #0099a1;
  height: 60px;
  border-radius: 10px;
  border: 0;
  padding: 0px;
  width: 100%;

  font-weight: 400;
  margin-top: 16px;
  transition: background-color 0.2s;

  &:hover {
    background: ${shade(0.2, '#24D7D2')};
  }
`;
