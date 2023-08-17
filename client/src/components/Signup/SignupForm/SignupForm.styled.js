import { styled } from 'styled-components';

export const From = styled.label`
  width: 400px;
  display: flex;
  flex-direction: column;
  box-shadow: 0 0 5px gray;
  border-radius: 10px;
  padding: 40px;
  margin: 40px 0px 20px 0px;
`;

export const Label = styled.h4`
  float: left;
  font-weight: 800;
  margin-bottom: 10px;
`;

export const Input = styled.input`
  width: 100%;
  height: 30px;
  margin-bottom: 30px;
  border-radius: 4px;
  border: 1px solid gray;
`;

export const EmailText = styled.div`
  font-size: 14px;
  font-weight: 600;
  color: #de5054;
  display: ${(props) => (props.emailText === 'null' ? 'null' : 'none')};
  position: fixed;
  top: 290px;
`;

export const PwText = styled.div`
  font-size: 14px;
  font-weight: 600;
  color: #de5054;
  display: ${(props) => (props.passwordText === 'null' ? 'null' : 'none')};
  position: fixed;
  top: 470px;
`;

export const Button = styled.button`
  width: 100%;
  height: 40px;
  background: #0a95ff;
  border-radius: 10px;
  color: white;
  margin: 20px 0px 10px 0px;
`;
