/* eslint-disable no-console */
/* eslint-disable no-alert */
import React from 'react';
import { Link } from 'react-router-dom';

import { Form } from '@unform/web';
import { TextField } from 'unform-material-ui';
import { FormHelperText } from '@material-ui/core';
// import MenuItem from '@material-ui/core/MenuItem';

import Button from '../../components/Button';
import api from '../../services/api';
import { Container, Content, Background } from './styles';

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

const CreatePatient: React.FC = () => {
  // Função para verificar se os dados estão completos, entao enviamos para api
  function handleSubmit(data: any, { reset }: any): void {
    if (data.name === '' || data.cpf === '' || data.uf === '') {
      alert('Dados Incompletos');
      reset();
    } else {
      try {
        api
          .post('/api/patients', data)
          .then(() => alert('Paciente cadastrado'));
        reset();
      } catch (error) {
        console.log(error);
      }
    }
  }

  // const [uf, setUf] = React.useState('MG');
  // function handleChange(e: ChangeEvent<HTMLInputElement>): void {
  //   setUf(e.target.value);
  // }

  return (
    <Container>
      <Content>
        <Form onSubmit={handleSubmit}>
          <TextField
            name="name"
            placeholder="Nome completo"
            label="Nome Completo"
          />
          <FormHelperText> Nome obrigatório</FormHelperText>
          <TextField name="cpf" placeholder="CPF" label="CPF" />
          <FormHelperText> CPF obrigatório</FormHelperText>
          <TextField
            name="birth"
            placeholder="Data de nascimento"
            label="Data de nascimento"
          />
          <TextField
            name="weight"
            placeholder="Peso em Kg"
            label="Peso em Kg"
          />
          <TextField
            name="height"
            placeholder="Altura em Metros"
            label="Altura em Metros"
          />

          {
            // Tentativa de adicionar o Select no formulário
            /* <TextField
            select
            name="uf"
            label="Selecione"
            value={uf}
            onChange={handleChange}
            helperText="Selecione seu estado"
          >
            {UF.map(option => (
              <MenuItem key={option.value} value={option.value}>
                {option.label}
              </MenuItem>
            ))}
          </TextField> */
          }

          <TextField name="uf" placeholder="UF" label="UF" />
          <FormHelperText> Uf Obrigatório</FormHelperText>
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
