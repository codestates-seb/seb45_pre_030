import styled from 'styled-components';

export const Container = styled.footer`
  background-color: hsl(210, 8%, 15%);
  height: 320px;
  display: flex;
  padding: 32px 12px 12px 12px;
  justify-content: center;
`;

export const LogoContainer = styled.div`
  height: 278px;
  width: 64px;
`;

export const Logo = styled.img`
  width: 32px;
  height: 37px;
`;

export const FooterNav = styled.nav`
  width: 851px;
  height: 278px;
  display: flex;
  flex-direction: row;
`;

export const FooterDiv = styled.div`
  display: flex;
  flex-direction: column;
  height: 278px;
  width: 268px;
`;

export const FooterH = styled.h1`
  font-weight: bolder;
  font-size: 13px;
  color: hsl(210deg 7.94% 80.14%);
  margin-bottom: 20px;
`;

export const FooterUl = styled.ul`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
`;

export const FooterLi = styled.li`
  font-size: medium;
  font-size: 13px;
  color: hsl(210deg 7.94% 60.14%);
  height: 25px;
`;
export const CopyDiv = styled.div`
  height: 278px;
  width: 324px;
`;

export const CopyUl = styled.ul`
  display: flex;
  flex-direction: row;
  height: 22px;
`;

export const CopyLi = styled.li`
  font-size: x-small;
  margin-right: 10px;
  color: hsl(210deg 7.94% 60.14%);
`;

export const Text = styled.p`
  font-size: x-small;
  color: hsl(210deg 7.94% 60.14%);
  margin-top: 202px;
  margin-bottom: 24px;
`;
