import { ValidationError } from 'yup';

interface Errors {
  [key: string]: string;
}

export default function getValidateErrors(err: ValidationError): Errors {
  const ValidationErrors: Errors = {};

  err.inner.forEach((error: any) => {
    ValidationErrors[error.path] = error.message;
  });

  return ValidationErrors;
}
