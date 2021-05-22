import styled from 'styled-components';
import Tooltip from '../../Tooltip';

interface ContainerProps {
  isErrored: boolean;
}

export const Container = styled.div<ContainerProps>``;

export const Error = styled(Tooltip)``;
