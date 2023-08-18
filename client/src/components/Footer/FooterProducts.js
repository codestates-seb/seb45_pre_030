import { FooterDiv, FooterH, FooterUl, FooterLi } from './Footer.styled';

function Products() {
  return (
    <FooterDiv>
      <FooterH>PRODUCT</FooterH>
      <FooterUl>
        <FooterLi>Teams</FooterLi>
        <FooterLi>Advertising</FooterLi>
        <FooterLi>Collectives</FooterLi>
        <FooterLi>Talent</FooterLi>
      </FooterUl>
    </FooterDiv>
  );
}

export default Products;
