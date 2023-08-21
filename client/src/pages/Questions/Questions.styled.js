import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  width: auto;
  justify-content: center;
`;

export const SectionContainer = styled.div`
  display: flex;
  justify-content: center;
  max-width: 1264px;
`;

export const Section = styled.div`
  &.questions-main-section {
    border-left: 1px solid hsl(210, 8%, 90%);
  }

  &.questions-side-section {
    padding-top: 24px;
  }
`;

export const TitleWrapper = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  margin-bottom: 24px;
  padding: 24px 0 0 24px;
`;

export const Title = styled.h1`
  font-weight: 400;
  font-size: 28px;
  line-height: 1.3;
`;

export const SubContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  padding-left: 24px;
`;

export const SubWrapper = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  margin-bottom: 12px;
`;

export const Total = styled.p`
  font-weight: 400;
  font-size: 2rem;
  line-height: 1.3;
  font-size: 1.1rem;
  font-weight: 100;
`;

export const FilterWrapper = styled.div`
  display: flex;
`;
