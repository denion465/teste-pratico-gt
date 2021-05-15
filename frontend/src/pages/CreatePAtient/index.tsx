import React from 'react';
import { Form } from '@unform/web';
import Button from '../../components/Button';
import Input from '../../components/Input';

import { Container } from './styles';

const CreatePAtient: React.FC = () => {
  function handleSubmit(data: object): void {
    console.log(data);
  }
  return (
    <Container>
      <Form onSubmit={handleSubmit}>
        <Input name="name" placeholder="Nome completo" />
        <Input name="cpf" placeholder="CPF" />
        <Input name="nascimento" placeholder="Data de nascimento" />
        <Input name="peso" placeholder="Peso em Kg" />
        <Input name="altura" placeholder="Altura em Metros" />
        <Input name="uf" placeholder="UF" />

        <Button type="submit">Criar</Button>
      </Form>
    </Container>
  );
};

export default CreatePAtient;
