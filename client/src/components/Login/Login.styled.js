import styled from 'styled-components';
import { Link } from 'react-router-dom';

export const Logo = styled.img`
  width: 50px;
  margin: 0 auto;
  margin-top: 40px;
`;

export const From = styled.label`
  width: 400px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  box-shadow: 0 0 5px gray;
  border-radius: 10px;
  margin-top: 40px;
  padding: 40px;
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

export const Button = styled.button`
  width: 100%;
  height: 40px;
  background: #0a95ff;
  border-radius: 10px;
  color: white;
`;

export const EmailText = styled.span`
  font-size: 14px;
  font-weight: 600;
  color: #de5054;
  display: ${(props) => (props.emailText === 'null' ? 'null' : 'none')};
  position: fixed;
  top: 286px;
`;

export const StyledNav = styled(Link)`
  color: #0074cc;
  font-size: 14px;
  margin: 0 auto;
  margin-top: 40px;
  margin-bottom: 40px;
`;

export const Text = styled.text`
  color: black;
`;
