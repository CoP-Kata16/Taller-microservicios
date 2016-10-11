package com.microservice.createnotification.pojo;


import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;


@XmlRootElement(name = "notification")
public class Notification
{
	@Id
	private String id;

	private String idType;

	private String title;

	private String description;


	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}


	/**
	 * @return the idTypo
	 */
	public String getIdType()
	{
		return idType;
	}


	/**
	 * @param idTypo the idTypo to set
	 */
	public void setIdType(String idType)
	{
		this.idType = idType;
	}


	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}


	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}


	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Notification [id=").append(id).append(", idType=").append(idType).append(", title=").append(title).append(", description=").append(description).append("]");
		return builder.toString();
	}


}
