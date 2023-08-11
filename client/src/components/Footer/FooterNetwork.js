import { FooterDiv, FooterH, FooterUl, FooterLi } from './Footer.styled';

function Network() {
  return (
    <FooterDiv>
      <FooterH>STACK EXCHANGE NETWORK</FooterH>
      <FooterUl>
        <FooterLi>Technology</FooterLi>
        <FooterLi>Culture & recreation</FooterLi>
        <FooterLi>Life & arts</FooterLi>
        <FooterLi>Science</FooterLi>
        <FooterLi>Professional</FooterLi>
        <FooterLi>Business</FooterLi>
        <br />
        <FooterLi>API</FooterLi>
        <FooterLi>Data</FooterLi>
      </FooterUl>
    </FooterDiv>
  );
}

export default Network;
