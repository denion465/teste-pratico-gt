/* eslint-disable no-console */
/* eslint-disable no-alert */
import React, { useCallback, useRef } from 'react';
import { Link } from 'react-router-dom';
import { Form } from '@unform/web';
import { FormHandles } from '@unform/core';
import * as Yup from 'yup';

import { Container, Content, Background } from './styles';

import getValidateErrors from '../../utils/getValidationError';

import Button from '../../components/Button';
import Input from '../../components/Input';
import Select from '../../components/Select';

const CreatePatient: React.FC = () => {
  const formRef = useRef<FormHandles>(null);

  const handleSubmit = useCallback(async (data, { reset }: any) => {
    reset();
    try {
      formRef.current?.setErrors({});

      const schema = Yup.object().shape({
        name: Yup.string().required('Nome Obrigatório'),
        cpf: Yup.string().required('CPF Obrigatório'),
        uf: Yup.string().required('UF Obrigatório'),
      });

      await schema.validate(data, {
        abortEarly: false,
      });
    } catch (error) {
      const errors = getValidateErrors(error);

      formRef.current?.setErrors(errors);
    }
  }, []);

  return (
    <Container>
      <Content>
        <Form onSubmit={handleSubmit} ref={formRef}>
          <Input name="name" placeholder="Digite seu nome" />
          <Input name="cpf" placeholder="Digite seu CPF" />
          <Input name="birth" placeholder="Data de nascimento" />
          <Input name="weight" placeholder="Peso em Kg" />
          <Input name="height" placeholder="Altura em Metros" />
          <Select name="uf" />
          <Button type="submit">Criar</Button>
          <Link to="/">
            <Button type="button">Voltar</Button>
          </Link>
        </Form>
      </Content>
      <Background />
    </Container>
  );
};

export default CreatePatient;

// <Select name="uf">
// {UF.map(option => (
//   <MenuItem key={option.value} value={option.value}>
//     {option.label}
//   </MenuItem>
// ))}
// </Select>

// Objetos com valor de estados não implementados
// const UF = [
//   {
//     value: 'AC',
//     label: 'AC',
//   },
//   {
//     value: 'AL',
//     label: 'AL',
//   },
//   {
//     value: 'AP',
//     label: 'AP',
//   },
//   {
//     value: 'AM',
//     label: 'AM',
//   },
//   {
//     value: 'BA',
//     label: 'BA',
//   },
//   {
//     value: 'CE',
//     label: 'CE',
//   },
//   {
//     value: 'DF',
//     label: 'DF',
//   },
//   {
//     value: 'ES',
//     label: 'ES',
//   },
//   {
//     value: 'GO',
//     label: 'GO',
//   },
//   {
//     value: 'MA',
//     label: 'MA',
//   },
//   {
//     value: 'MT',
//     label: 'MT',
//   },
//   {
//     value: 'MS',
//     label: 'MS',
//   },
//   {
//     value: 'MG',
//     label: 'MG',
//   },
//   {
//     value: 'PA',
//     label: 'PA',
//   },
//   {
//     value: 'PB',
//     label: 'PB',
//   },
//   {
//     value: 'PR',
//     label: 'PR',
//   },
//   {
//     value: 'PE',
//     label: 'PE',
//   },
//   {
//     value: 'PI',
//     label: 'PI',
//   },
//   {
//     value: 'RJ',
//     label: 'RJ',
//   },
//   {
//     value: 'RN',
//     label: 'RN',
//   },
//   {
//     value: 'RS',
//     label: 'RS',
//   },
//   {
//     value: 'RO',
//     label: 'RO',
//   },
//   {
//     value: 'RR',
//     label: 'RR',
//   },
//   {
//     value: 'SC',
//     label: 'SC',
//   },
//   {
//     value: 'SP',
//     label: 'SP',
//   },
//   {
//     value: 'TO',
//     label: 'TO',
//   },
// ];
