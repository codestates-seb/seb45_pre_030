import styled from 'styled-components';
import { Link } from 'react-router-dom';

export const HeaderBox = styled.div`
  flex: 1;
`;

export const Bar = styled.div`
  width: 100%;
  height: 3px;
  background: #f48224;
`;

export const Head = styled.div`
  display: flex;
  justify-content: space-between;
  border-bottom: solid 1px #eee;
  height: 50px;
  padding: 0px 28px;
  display: flex;
  align-items: center;
`;

export const Logo = styled.img`
  width: 28px;
`;

export const StyledLink = styled(Link)`
  font-size: 18px;
`;

export const Nav = styled.div`
  font-size: 14px;
`;

export const StyledNav = styled(Link)`
  font-size: 14px;
  font-weight: 400;
  border-radius: 6px;
  padding: 6px 12px;

  &:nth-child(1) {
    background: #cce9fe;
    color: #0074cc;
    margin-right: 10px;
  }
  &:nth-child(2) {
    background: #0074cc;
    color: white;
  }
`;

export const FontW = styled.span`
  font-weight: 900;
`;

export const QuestionInput = styled.input`
  width: 600px;
  height: 30px;
  border-radius: 6px;
  border: 0.5px solid gray;
  padding: 0px 10px;
`;

export const UserStyledNav = styled(Link)`
  font-weight: 500;
  padding-right: 10px;
`;
