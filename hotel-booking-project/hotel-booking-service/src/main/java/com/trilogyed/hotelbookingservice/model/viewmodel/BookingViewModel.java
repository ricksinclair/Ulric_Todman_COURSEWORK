package com.trilogyed.hotelbookingservice.model.viewmodel;

import java.util.Objects;

public class BookingViewModel {

    private int roomId;
    private boolean rewardsMember;
    private boolean doubleBonusDay;
    private Float baseRate;
    private Float memberDiscount;
    private int baseRewardPoints;
    private boolean canDouble;
    private Float finalCost;
    private int totalRewardPoints;

    public BookingViewModel(){

    }

    public BookingViewModel(int roomId, boolean rewardsMember, boolean doubleBonusDay, Float baseRate, Float memberDiscount, int baseRewardPoints, boolean canDouble, Float finalCost, int totalRewardPoints) {
        this.roomId = roomId;
        this.rewardsMember = rewardsMember;
        this.doubleBonusDay = doubleBonusDay;
        this.baseRate = baseRate;
        this.memberDiscount = memberDiscount;
        this.baseRewardPoints = baseRewardPoints;
        this.canDouble = canDouble;
        this.finalCost = finalCost;
        this.totalRewardPoints = totalRewardPoints;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public boolean isRewardsMember() {
        return rewardsMember;
    }

    public void setRewardsMember(boolean rewardsMember) {
        this.rewardsMember = rewardsMember;
    }

    public boolean isDoubleBonusDay() {
        return doubleBonusDay;
    }

    public void setDoubleBonusDay(boolean doubleBonusDay) {
        this.doubleBonusDay = doubleBonusDay;
    }

    public Float getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(Float baseRate) {
        this.baseRate = baseRate;
    }

    public Float getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(Float memberDiscount) {
        this.memberDiscount = memberDiscount;
    }

    public int getBaseRewardPoints() {
        return baseRewardPoints;
    }

    public void setBaseRewardPoints(int baseRewardPoints) {
        this.baseRewardPoints = baseRewardPoints;
    }

    public boolean isCanDouble() {
        return canDouble;
    }

    public void setCanDouble(boolean canDouble) {
        this.canDouble = canDouble;
    }

    public Float getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(Float finalCost) {
        this.finalCost = finalCost;
    }

    public int getTotalRewardPoints() {
        return totalRewardPoints;
    }

    public void setTotalRewardPoints(int totalRewardPoints) {
        this.totalRewardPoints = totalRewardPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingViewModel that = (BookingViewModel) o;
        return getRoomId() == that.getRoomId() &&
                isRewardsMember() == that.isRewardsMember() &&
                isDoubleBonusDay() == that.isDoubleBonusDay() &&
                getBaseRewardPoints() == that.getBaseRewardPoints() &&
                isCanDouble() == that.isCanDouble() &&
                getTotalRewardPoints() == that.getTotalRewardPoints() &&
                getBaseRate().equals(that.getBaseRate()) &&
                getMemberDiscount().equals(that.getMemberDiscount()) &&
                getFinalCost().equals(that.getFinalCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomId(), isRewardsMember(), isDoubleBonusDay(), getBaseRate(), getMemberDiscount(), getBaseRewardPoints(), isCanDouble(), getFinalCost(), getTotalRewardPoints());
    }

    @Override
    public String toString() {
        return "BookingViewModel{" +
                "roomId=" + roomId +
                ", rewardsMember=" + rewardsMember +
                ", doubleBonusDay=" + doubleBonusDay +
                ", baseRate=" + baseRate +
                ", memberDiscount=" + memberDiscount +
                ", baseRewardPoints=" + baseRewardPoints +
                ", canDouble=" + canDouble +
                ", finalCost=" + finalCost +
                ", totalRewardPoints=" + totalRewardPoints +
                '}';
    }
}
