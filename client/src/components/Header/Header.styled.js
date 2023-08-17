import styled from 'styled-components';
import { Link } from 'react-router-dom';

export const Head = styled.div`
  display: flex;
  justify-content: space-between;
  border-bottom: solid 1px #eee;
  height: 60px;
  padding: 0px 70px;
  display: flex;
  align-items: center;
`;

export const StyledLink = styled(Link)`
  font-size: 18px;
`;

export const Nav = styled.div`
  font-size: 14px;
`;

export const StyledNav = styled(Link)`
  padding-left: 10px;
`;

export const FontW = styled.span`
  font-weight: 900;
`;

export const QuestionInput = styled.input`
  width: 50%;
  height: 30px;
  border-radius: 6px;
  border: 0.5px solid gray;
  padding: 0px 10px;
`;
