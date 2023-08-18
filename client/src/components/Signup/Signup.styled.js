import { styled } from 'styled-components';

export const From = styled.label`
  width: 600px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  box-shadow: 0 0 5px gray;
  border-radius: 10px;
  margin-top: 40px;
`;

export const Head = styled.h1`
  margin: 40px;
  font-weight: 900;
  font-size: 20px;
`;

export const Label = styled.h4`
  margin-left: 40px;
  float: left;
  font-weight: 500;
  margin-bottom: 10px;
`;

export const Input = styled.input`
  margin-left: 40px;
  width: 80%;
  height: 30px;
  margin-bottom: 30px;
`;

export const Button = styled.button`
  margin-left: 40px;
  width: 82%;
  height: 40px;
  margin: 20px 40px;
  background: #0a95ff;
  border-radius: 10px;
  font-weight: 600;
  color: white;
`;

export const EmailText = styled.div`
  margin-left: 40px;
  font-size: 14px;
  font-weight: 500;
  color: red;
  display: ${(props) => (props.emailText === 'null' ? 'null' : 'none')};
  position: fixed;
  top: 358px;
`;

export const PwText = styled.div`
  margin-left: 40px;
  font-size: 14px;
  font-weight: 500;
  color: red;
  display: ${(props) => (props.passwordText === 'null' ? 'null' : 'none')};
  position: fixed;
  top: 540px;
`;
